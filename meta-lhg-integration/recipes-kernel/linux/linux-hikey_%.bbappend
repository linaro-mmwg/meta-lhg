FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_hikey = " \
    file://0001-drm-hisilicon-Ensure-all-LDI-regs-are-properly-configured.patch \
"
