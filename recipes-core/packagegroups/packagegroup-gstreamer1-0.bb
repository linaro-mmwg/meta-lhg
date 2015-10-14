DESCRIPTION = "Gstreamer 1.0 components"
LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/LGPL-2.0;md5=9427b8ccf5cf3df47c29110424c9641a"

PR = "r0"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PACKAGES = "\
    packagegroup-gstreamer1-0 \
    "

PROVIDES = "${PACKAGES}"
RDEPENDS_packagegroup-gstreamer1-0 = "\
    libsoup-2.4 \
    librsvg \
    libcroco \
    libfaac \
    gstreamer1.0 \
    \
    packagegroup-gstreamer1-0-plugins-base \
    \
    packagegroup-gstreamer1-0-plugins-good \
    \
    packagegroup-gstreamer1-0-plugins-bad \
    \
    gstreamer1.0-libav \
"

