FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DESCRIPTION_hikey = "Hisilicon 4.5 Kernel"

PV_hikey = "4.5+git"

SRCREV_kernel_hikey="41f296fffdc19663845d4aa88b5df1ee6a581277"

SRC_URI_hikey = "git://github.com/andrey-konovalov/linux;branch=hikey_optee_smaf-utgard;protocol=https;name=kernel \
    file://defconfig;name=defconfig \
        "

do_unpack_hack_distroconfig() {
    mv ${WORKDIR}/defconfig ${S}/arch/arm64/configs/distro.config
}

do_unpack_append_hikey() {
    bb.build.exec_func('do_unpack_hack_distroconfig', d)
}
