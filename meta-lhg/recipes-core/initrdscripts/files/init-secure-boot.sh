#!/bin/sh

PATH=/sbin:/bin:/usr/sbin:/usr/bin

tmproot="/root"
rootpath="/root"

#mkdir /proc
#mkdir /sys
mount -t proc proc /proc
mount -t sysfs sysfs /sys
mount -t devtmpfs none /dev




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

file1= "$tmproot/proc"
if [ -f "$file1" ]
then
   echo "rootfs is extracted"
else
  rm $tmproot/IsSign

cd $tmproot
#
file="$tmproot/IsSign"
if [ -f "$file" ]
then
	echo "Signed and mounetd."
else
cat <<EOF >$tmproot/command.sh
openssl dgst -sha256 -verify <(openssl x509 -in root.crt  -pubkey -noout) -signature *.sha256 *.tar.xz
EOF
cat command.sh
bash command.sh >IsSign
str=$(cat $file)
#  echo "$str printing this"
   if [ "$str" = 'Verified OK' ]
   then
      echo "Rootfs tar is having valid signature"
    tar xf $tmproot/*.tar.xz
   else
      echo "not valid Rootfs....."
      rm $tmproot/IsSign
   fi


fi
fi
#cat <<EOF >/root/command.sh
#openssl dgst -sha256 -verify <(openssl x509 -in root.crt  -pubkey -noout) -signature *.sha256 *.tar.bz2
#EOF
#cat command.sh
#bash command.sh >IsSign

#tar jxf *.tar.bz2

mount -n --move /proc $rootpath/proc
mount -n --move /sys $rootpath/sys
mount -n --move /dev $rootpath/dev

#cd /root

exec switch_root -c /dev/console $rootpath /sbin/init

