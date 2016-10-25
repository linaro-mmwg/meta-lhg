require recipes-samples/images/rpb-weston-image.bb

CORE_IMAGE_BASE_INSTALL += " \
    libexif \
    chromium \
    ${@base_contains('MACHINE_FEATURES', 'optee', 'optee-aes-decryptor ocdmi portmap', '', d)} \
    "
