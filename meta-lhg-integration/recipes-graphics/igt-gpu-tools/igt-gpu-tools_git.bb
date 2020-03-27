SUMMARY = "IGT GPU Tools"
DESCRIPTION = "IGT GPU Tools is a collection of tools for development and testing of the DRM drivers"

LIC_FILES_CHKSUM = "file://COPYING;md5=67bfee4df38fa6ecbe3a675c552d4c08"

LICENSE_append = " & ISC"

inherit meson gtk-doc

SRCREV = "${AUTOREV}"

SRC_URI = "git://gitlab.freedesktop.org/drm/igt-gpu-tools.git;protocol=https"

S = "${WORKDIR}/git"

DEPENDS += "libdrm libpciaccess cairo udev glib-2.0 procps libunwind kmod openssl xmlrpc-c gsl elfutils alsa-lib json-c bison-native"
RDEPENDS_${PN} += "bash python3-mako python3-six git net-snmp"

PACKAGE_BEFORE_PN = "${PN}-benchmarks"

EXTRA_OEMESON = "-Ddocs=disabled -Dchamelium=enabled"
COMPATIBLE_HOST = "(x86_64.*|i.86.*|arm.*|aarch64).*-linux"
COMPATIBLE_HOST_libc-musl_class-target = "null"

gputools_sysroot_preprocess() {
	rm -f ${SYSROOT_DESTDIR}${libdir}/pkgconfig/intel-gen4asm.pc
}
SYSROOT_PREPROCESS_FUNCS += "gputools_sysroot_preprocess"

do_install_append() {
    install -d ${D}/usr/share/${BPN}/scripts
    install ${S}/scripts/run-tests.sh ${D}/usr/share/${BPN}/scripts
}

FILES_${PN}-benchmarks += "${libexecdir}/${BPN}/benchmarks"
FILES_${PN} += "\
        ${libexecdir}/${BPN}/*\
        ${libdir}/intel_aubdump.so \
        ${datadir}/${BPN}/1080p-right.png\
        ${datadir}/${BPN}/1080p-left.png\
        ${datadir}/${BPN}/pass.png\
        ${datadir}/${BPN}/test-list.txt"
