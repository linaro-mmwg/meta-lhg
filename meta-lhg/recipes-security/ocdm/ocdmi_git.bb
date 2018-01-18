#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

DESCRIPTION = "Open Content Decryption Module"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ea83f8bc099c40bde8c4f2441a6eb40b"

SRC_URI = "git://github.com/linaro-home/open-content-decryption-module-cdmi.git;protocol=https;branch=master"
SRCREV_pn-ocdmi ?= "${AUTOREV}"

S = "${WORKDIR}/git"

EXTRA_OECONF_append = "${@bb.utils.contains('MACHINE_FEATURES', 'optee', '--enable-aes-ta', '', d)} "

# * --enable-playready : Enables support for Playready CDMI.
#
# * --enable-debug : Builds OCDM with debug symbols and verbose logging.

# Only ClearKey implementation depends on ssl:
DEPENDS_append = " \
    ${@bb.utils.contains('PACKAGECONFIG','--enable-playready','','openssl',d)} \
    rpcbind \
    ${@bb.utils.contains('MACHINE_FEATURES','optee','optee-aes-decryptor','',d)} \
"

inherit autotools
