PROVIDES_remove = "${@bb.utils.contains("MACHINE_FEATURES", "sgx", "virtual/libgles1 virtual/libgles2 virtual/egl", "", d)}"

PACKAGECONFIG_remove = "${@bb.utils.contains("MACHINE_FEATURES", "sgx", "gbm egl gles wayland", "", d)}"

PACKAGES_remove = "${@bb.utils.contains("MACHINE_FEATURES", "sgx", "libgbm libgbm-dev", "", d)}"
