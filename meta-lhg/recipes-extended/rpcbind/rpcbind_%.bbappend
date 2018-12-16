pkg_postinst_${PN}() {
    echo 127.0.0.1    ${MACHINE} >> $D/etc/hosts
}
