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

SRC_URI_append_hikey = " \
    file://0001-edk2-remove-warning.patch \
"
