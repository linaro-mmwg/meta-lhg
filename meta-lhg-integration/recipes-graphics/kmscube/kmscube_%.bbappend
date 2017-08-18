FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://0001-Dont-check-for-gbm-version-do-check-egl-version-requ.patch \
    "
