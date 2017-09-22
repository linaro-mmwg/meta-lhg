#!/bin/sh

PATH=/sbin:/bin:/usr/sbin:/usr/bin

tmproot="/root"
rootpath="/root"

mount -t proc proc /proc
mount -t sysfs sysfs /sys
mount -t devtmpfs none /dev

#added for extracting certificate from efi variable
mount -t efivarfs none /sys/firmware/efi/efivars
cat /sys/firmware/efi/efivars/RdkRootCertificate* > root.crt
dd if=root.crt of=temp.crt bs=1 skip=4
mv temp.crt root.crt
mkdir /root
#mv root.crt /root
echo "root.crt file created"

read_args() {
	[ -z "$CMDLINE" ] && CMDLINE=`cat /proc/cmdline`
	for arg in $CMDLINE; do
		optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
		case $arg in
			root=*)
				ROOT_DEVICE=$optarg ;;
			rootimage=*)
				ROOT_IMAGE=$optarg ;;
			rootfstype=*)
				modprobe $optarg 2> /dev/null ;;
			LABEL=*)
				label=$optarg ;;
			video=*)
				video_mode=$arg ;;
			vga=*)
				vga_mode=$arg ;;
			console=*)
				if [ -z "${console_params}" ]; then
					console_params=$arg
				else
					console_params="$console_params $arg"
				fi ;;
			debugshell*)
				if [ -z "$optarg" ]; then
					shelltimeout=30
				else
					shelltimeout=$optarg
				fi
		esac
	done
}

modprobe isofs 2> /dev/null
mkdir -p /run
mkdir -p /var/run
udevd &

df -h
cat /proc/mounts

killall udevd

read_args

mount -o rw,loop,noatime,nodiratime $ROOT_DEVICE $tmproot
cp /root.crt root/

file1="$tmproot/proc"
if [ -d "$file1" ]; then
	echo 'Rootfs available already... Mounting rootfs...'
else
	cd $tmproot

	file="$tmproot/IsSign"
	cat <<EOF > $tmproot/command.sh
	openssl dgst -sha256 -verify <(openssl x509 -in root.crt  -pubkey -noout) -signature *.sha256 *.tar.gz
EOF
	bash command.sh >$file
	str=$(cat $file)
	if [ "$str" = 'Verified OK' ]; then
		echo "Rootfs tar is having valid signature"
		echo "Extracting root fs ..."
		tar xzf $tmproot/*.tar.gz
		sync
                echo "Rootfs extracted"
	else
		echo "not valid Rootfs....."
		exit
	fi
fi

mount -n --move /proc $rootpath/proc
mount -n --move /sys $rootpath/sys
mount -n --move /dev $rootpath/dev

exec switch_root -c /dev/console $rootpath /sbin/init

if [ $? -eq 0 ]; then
	echo 'switch root success'
else
	exec sh
fi
