FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://Manually_mmap_heap_memory_esr17.patch;patchdir=../../"
