#
# This file was derived from the 'Hello World!' example recipe in the
# Yocto Project Development Manual.
#

DESCRIPTION = "Open Content Decryption Module"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ea83f8bc099c40bde8c4f2441a6eb40b"

SRC_URI = "git://github.com/kuscsik/linaro-cdmi.git;protocol=https;branch=master"
SRCREV_pn-ocdmi ?= "${AUTOREV}"

S = "${WORKDIR}/git"

# * use-playready : Enables support for Playready CDMI.
#
# * debug-build : Builds OCDM with debug symbols and verbose logging.

DEPENDS_append = "  openssl "

# Only ClearKey implementation depends on ssl
DEPENDS_remove = " \
  ${@base_contains('PACKAGECONFIG','use-playready','openssl','',d)} \
  "

inherit autotools
