PACKAGECONFIG_append = " ${@base_contains('MACHINE_FEATURES', 'optee', 'use-ocdm', '', d)} proprietary-codecs"
