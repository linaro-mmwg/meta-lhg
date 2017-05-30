FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_hikey = " \
    file://0001-plat-hikey-update-the-memory-layout-description.patch \
    file://0002-plat-hikey-configure-and-enable-Secure-Data-Path-by-.patch \
"
