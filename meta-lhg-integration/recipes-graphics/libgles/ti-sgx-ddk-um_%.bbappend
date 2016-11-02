FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://0001-HACK-bump-up-egl-s-and-wayland-egl-s-version-numbers.patch"

do_install_append () {
    (cd ${D}/${libdir} && ln -sf libGLESv2.so libGLESv2.so.2)
}
