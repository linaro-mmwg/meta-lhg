SUMMARY = "html2text"
DESCRIPTION = "Converts HTML documents into plain text"
HOMEPAGE = "http://www.mbayer.de/html2text/"
SECTION = "console/utils"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=7783169b4be06b54e86730eb01bc3a31"

SRC_URI = "ftp://ftp.ibiblio.org/pub/linux/apps/www/converters/${BPN}-${PV}.tar.gz \
           file://0001-Make-it-cross-compileable.patch"

SRC_URI[md5sum] = "6097fe07b948e142315749e6620c9cfc"
SRC_URI[sha256sum] = "000b39d5d910b867ff7e087177b470a1e26e2819920dcffd5991c33f6d480392"

inherit autotools

B = "${S}"

do_configure() {
  cd ${S} ; CC="${CXX}" ./configure
}

do_install() {
  mkdir -p ${D}/usr/bin/
  install -m 0755 ${S}/html2text ${D}/usr/bin/
}

FILES_${PN} = "/usr"
