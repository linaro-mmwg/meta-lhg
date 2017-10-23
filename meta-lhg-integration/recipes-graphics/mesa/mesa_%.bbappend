do_install_append_omap-15() {
    # Remove libgbm provided by Mesa as omap-a15 uses the one from meta-ti
    rm -f ${D}/${libdir}/libgbm.*
}

PROVIDES_remove = "${@bb.utils.contains("MACHINE_FEATURES", "sgx", "virtual/libgles1 virtual/libgles2 virtual/egl", "", d)}"

PACKAGECONFIG_remove = "${@bb.utils.contains("MACHINE_FEATURES", "sgx", "gbm egl gles", "", d)}"

PACKAGES_remove = "${@bb.utils.contains("MACHINE_FEATURES", "sgx", "libgbm libgbm-dev", "", d)}"
