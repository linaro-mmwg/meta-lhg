SUMMARY = "Mali450 libraries (drm backend)"
DESCRIPTION = "Mali450 libraries (opengles, egl...)"
LICENSE = "Proprietary"
#LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=6b6d38be6224fa5948bf814d28cc2197"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "libdrm wayland"

PV_MALI="r6p0"
PR_MALI="01rel0"

PV="${PV_MALI}"
PR="${PR_MALI}.binary"

BACKEND="drm"

MALI_DIRECTORY="mali450-userland-${BACKEND}-${PV_MALI}-${PR_MALI}-release"
SRC_URI = "file://${MALI_DIRECTORY}.tgz"

S = "${WORKDIR}/${MALI_DIRECTORY}"

#action stubbed
do_configure[noexec] = "1"
do_compile[noexec] = "1"


do_install() {
    install -m 755 -d ${D}/usr/
    cp -aR ${S}/usr ${D}/
}


PROVIDES += " mali450-userland virtual/libgles1 virtual/libgles2 virtual/egl virtual/gbm"
PACKAGES = "${PN} ${PN}-dev "

INSANE_SKIP_${PN} = "dev-so"
FILES_SOLIBSDEV = ""

RPROVIDES_${PN}  = "libegl libegl1 libgles1 libglesv1-cm1 libgles2 libglesv2-2 libvg libgbm"
RREPLACES_${PN}  = "libegl libegl1 libgles1 libglesv1-cm1 libgles2 libglesv2-2 libvg libgbm"
RCONFLICTS_${PN} = "libegl libegl1 libgles1 libglesv1-cm1 libgles2 libglesv2-2 libgbm"

FILES_${PN}           = "${libdir}/libEGL.so* ${libdir}/libGLESv1_CM.so* ${libdir}/libGLESv2.so* "
FILES_${PN}           += "${libdir}/libgbm.so* ${libdir}/libwayland*.so* "
FILES_${PN}           += "${libdir}/libMali.so"

FILES_${PN}-dev       += "${includedir} ${libdir}/pkgconfig/"
FILES_${PN}-dbg       += "${libdir}/.debug/*.so* ${bindir}/.debug/ "
