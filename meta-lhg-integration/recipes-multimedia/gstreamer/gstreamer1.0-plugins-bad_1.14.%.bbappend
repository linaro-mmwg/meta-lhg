FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

#    file://0001-gstdrmallocator-Add-DRM-allocator-support.patch \
#    file://0003-kmssink-Add-omapdrm-in-the-list-of-driver-modules.patch \
#    file://0004-waylandsink-Add-drm-support-in-waylandsink.patch \
#    file://0005-waylandsink-Add-input-device-support.patch
SRC_URI_append_ti43x = " \
    file://0002-parsers-bug-fixes-on-parsers.patch \
"

SRC_URI_append_ti33x = " \
    file://0001-waylandsink-Add-mouse-drag-and-drop-support.patch \
"

#    file://0001-gstdrmallocator-Add-DRM-allocator-support.patch \
#    file://0003-kmssink-Add-omapdrm-in-the-list-of-driver-modules.patch \
#    file://0004-waylandsink-Add-drm-support-in-waylandsink.patch \
#    file://0005-waylandsink-Add-input-device-support.patch
SRC_URI_append_omap-a15 = " \
    file://0002-parsers-bug-fixes-on-parsers.patch \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
