FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:${THISDIR}/${PN}-${PV}:"

SRC_URI_append_omap-a15 = " \
	file://0001-weston1.9.0-Enabling-DRM-backend-with-multiple-displ.patch \
	file://0002-Weston1.9.0-Allow-visual_id-to-be-0.patch \
	file://0003-Weston1.9.0-Fix-virtual-keyboard-display-issue-for-Q.patch \
	file://0004-Weston1.9.0-Fix-touch-screen-crash-issue.patch \
	file://0001-udev-seat-restrict-udev-enumeration-to-card0.patch \
	file://0001-Add-soc-performance-monitor-utilites.patch \
"

PACKAGECONFIG_remove_omap-a15 = "wayland fbdev"
PACKAGECONFIG[kms] := "--enable-drm-compositor,--disable-drm-compositor,drm udev ${@bb.utils.contains('MACHINE_FEATURES', 'sgx', 'libgbm', 'virtual/mesa', d)} mtdev"
