FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

#remove updated patch for 1.16.1 that doesn't apply cleanly on 1.16 nxp fork
SRC_URI_remove_mx8 = "file://0006-Manual-revert-of-bfd0e022-qtdemux-rework-segment-eve.patch"
SRC_URI_append_mx8 = "file://0006-Manual-revert-of-bfd0e022-qtdemux-rework-segment-eve-1.16.patch"
