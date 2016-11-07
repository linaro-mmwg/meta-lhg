DEPENDS_remove = "${@bb.utils.contains("MACHINE_FEATURES", "sgx", "virtual/mesa", "", d)}"
DEPENDS_append = "${@bb.utils.contains("MACHINE_FEATURES", "sgx", " virtual/egl", "", d)}"
