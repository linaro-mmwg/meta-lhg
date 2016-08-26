FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DESCRIPTION_hikey = "Hisilicon 4.5 Kernel"

PV_hikey = "4.5+git"

SRCREV_kernel_hikey="8b5abc8ac880aa644fe387a7bfd4c1ca30245967"

SRC_URI_hikey = "git://github.com/andrey-konovalov/linux;branch=hikey_optee_smaf-utgard;protocol=https;name=kernel \
    file://defconfig;name=defconfig \
        "

do_unpack_hack_distroconfig() {
    mv ${WORKDIR}/defconfig ${S}/arch/arm64/configs/distro.config
}

do_unpack_append_hikey() {
    bb.build.exec_func('do_unpack_hack_distroconfig', d)
}
