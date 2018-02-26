require recipes-samples/images/rpb-weston-image.bb

CORE_IMAGE_BASE_INSTALL += " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'optee', 'optee-aes-decryptor ocdmi rpcbind', '', d)} \
    "
