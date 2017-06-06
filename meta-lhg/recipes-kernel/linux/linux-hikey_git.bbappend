do_configure_append() {
    # Enable EFI file system
    sed -i '/CONFIG_EFI_VARS/d' ${B}/.config
    sed -i '/CONFIG_EFIVAR_FS/d' ${B}/.config

    echo 'CONFIG_EFI_VARS=y' >> ${B}/.config
    echo 'CONFIG_EFIVAR_FS=y' >> ${B}/.config

    echo 'CONFIG_EFI_VARS_PSTORE=n' >> ${B}/.config
}
