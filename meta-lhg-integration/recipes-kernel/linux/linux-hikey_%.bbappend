FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_hikey = " \
    file://0001-drm-hisilicon-Ensure-all-LDI-regs-are-properly-configured.patch \
    file://0001-staging-ion-add-Allwinner-ION-secure-heap-not-for-ma.patch \
    file://0002-ion-unmapped-heap-for-secure-data-path-not-for-mainl.patch \
    file://0003-ion-unmapped-heap-support-in-ion-dummy-driver-not-fo.patch \
    file://ion-kernel.conf;subdir=git/kernel/configs \
"

KERNEL_CONFIG_FRAGMENTS_hikey += "${S}/kernel/configs/ion-kernel.conf"
