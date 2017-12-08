SUMMARY = "Organize packages to avoid duplication across all images (wayland)"

inherit packagegroup distro_features_check
REQUIRED_DISTRO_FEATURES = "wayland"

SUMMARY_packagegroup-rpb-wayland = "Apps that can be used in Wayland Desktop"
RDEPENDS_packagegroup-rpb-wayland = "\
    clutter-1.0-examples \
    gps-utils \
    gpsd \
    gstreamer1.0-plugins-bad-meta \
    gstreamer1.0-plugins-base-meta \
    gstreamer1.0-plugins-good-meta \
    ${@bb.utils.contains("LICENSE_FLAGS_WHITELIST", "commercial_gstreamer1.0-libav", "gstreamer1.0-libav", "", d)} \
    kmscube \
    ${@bb.utils.contains("MACHINE_FEATURES", "mali450", "mali450-userland", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "sgx", "libgbm ti-sgx-ddk-km ti-sgx-ddk-um pru-icss", "", d)} \
    "

