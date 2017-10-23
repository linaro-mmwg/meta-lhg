FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PV_hikey = "1.0+git"

SRCREV_edk2_hikey = "465663e9f128428323e6c6e4431dd15ac287a24c"
SRCREV_atf_hikey = "fb1158a365e2bf5bba638cde950678fddf67fe60"
SRCREV_openplatformpkg_hikey = "0fcfe9d6f85dfed70dad391077b79a58363c9f6a"
SRCREV_uefitools_hikey = "abbe1c0a2dbeadde0e3c5f3a183f6c595b70158e"
SRCREV_rdkpkg_hikey = "e63c8172aa0c369972049a272152bb080e881923"
SRC_URI[openssl.md5sum] = "96322138f0b69e61b7212bc53d5e912b"

SRC_URI_hikey = "git://github.com/tianocore/edk2.git;name=edk2 \
	         git://github.com/96boards-hikey/arm-trusted-firmware.git;name=atf;branch=hikey;destsuffix=git/atf \
       		 git://github.com/linaro-home/OpenPlatformPkg.git;name=openplatformpkg;branch=hikey-rdk;destsuffix=git/OpenPlatformPkg \
           	 git://git.linaro.org/uefi/uefi-tools.git;name=uefitools;destsuffix=git/uefi-tools \
	   	 git://github.com/linaro-home/RdkPkg.git;name=rdkpkg;destsuffix=git/RdkPkg \
	   	 https://ftp.openssl.org/source/old/1.0.2/openssl-1.0.2j.tar.gz;name=openssl \
           	 file://grub.cfg.in \
          	"

do_compile_prepend() {
    cp -r ${EDK2_DIR}/../openssl-1.0.2j ${EDK2_DIR}/CryptoPkg/Library/OpensslLib
}

do_compile() {
    # Add in path to native sysroot to find uuid/uuid.h
    sed -i -e 's:-I \.\.:-I \.\. -I ${STAGING_INCDIR_NATIVE} :' ${S}/BaseTools/Source/C/Makefiles/header.makefile
    # ... and the library itself
    sed -i -e 's: -luuid: -luuid -L ${STAGING_LIBDIR_NATIVE}:g' ${S}/BaseTools/Source/C/*/GNUmakefile

    ${EDK2_DIR}/uefi-tools/uefi-build.sh -T ${AARCH64_TOOLCHAIN} -b DEBUG -a ${EDK2_DIR}/atf ${OPTEE_OS_ARG} ${UEFIMACHINE}
}

do_install() {
    install -D -p -m0644 ${EDK2_DIR}/atf/build/${UEFIMACHINE}/release/bl1.bin ${D}${libdir}/edk2/bl1.bin

    # Install grub configuration
    sed -e "s|@DISTRO|${DISTRO}|" \
        -e "s|@KERNEL_IMAGETYPE|${KERNEL_IMAGETYPE}|" \
        -e "s|@CMDLINE|${CMDLINE}|" \
        < ${WORKDIR}/grub.cfg.in \
        > ${WORKDIR}/grub.cfg
    install -D -p -m0644 ${WORKDIR}/grub.cfg ${D}/boot/grub/grub.cfg
}

do_deploy_prepend() {
    mkdir -p ${EDK2_DIR}/Build/HiKey/RELEASE_${AARCH64_TOOLCHAIN}/AARCH64
    touch ${EDK2_DIR}/Build/HiKey/RELEASE_${AARCH64_TOOLCHAIN}/AARCH64/AndroidFastbootApp.efi
}

SRC_URI_append_hikey = " \
    file://0001-edk2-remove-warning.patch \
"
