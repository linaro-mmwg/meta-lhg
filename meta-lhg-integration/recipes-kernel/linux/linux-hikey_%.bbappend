FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_hikey = " \
    file://0001-drm-hisilicon-Ensure-all-LDI-regs-are-properly-configured.patch \
    file://0002-add-secure-heap.patch \
    file://0003-register-tee_shm-from-a-dmabuf-file-descriptor.patch \
    file://defconfig;subdir=git/kernel/configs \    
"
