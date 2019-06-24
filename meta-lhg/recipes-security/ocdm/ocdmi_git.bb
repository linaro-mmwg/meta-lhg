
#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

DESCRIPTION = "Open Content Decryption Module"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ea83f8bc099c40bde8c4f2441a6eb40b"

SRC_URI = "git://github.com/linaro-mmwg/open-content-decryption-module-cdmi.git;protocol=https;branch=master"
SRCREV_pn-ocdmi ?= "${AUTOREV}"

S = "${WORKDIR}/git"

CFLAGS += "-I${STAGING_INCDIR}/tirpc"
CPPFLAGS += "-I${STAGING_INCDIR}/tirpc"

inherit autotools pkgconfig

EXTRA_OECONF_append = "${@bb.utils.contains('MACHINE_FEATURES', 'optee', ' --enable-aes-ta', '', d)} "

# * --enable-playready : Enables support for Playready CDMI.
#
# * --enable-debug : Builds OCDM with debug symbols and verbose logging.

# Only ClearKey implementation depends on ssl:
DEPENDS_append = " \
    ${@bb.utils.contains('PACKAGECONFIG','--enable-playready','','openssl',d)} \
    rpcbind \
    ${@bb.utils.contains('MACHINE_FEATURES','optee','optee-aes-decryptor','',d)} \
"

PACKAGECONFIG ??= "rpc"
PACKAGECONFIG[rpc] = "--enable-tirpc,--disable-tirpc,libtirpc"
