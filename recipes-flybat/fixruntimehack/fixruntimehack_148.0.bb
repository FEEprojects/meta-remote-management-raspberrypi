SUMMARY="Package that fixes docker arm interpreter path"
DESCRIPTION="Package that adds /lib/ld-linux.so.3 as symlink so docker and other binaries run without needing to symlink manually on first boot"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "\
        file://fixruntimehack.txt \
"

pkg_postinst_${PN}() {
#!/bin/sh

if [ -n "$D" ]; then
    cd $D/lib
    ln -s ld-linux-armhf.so.3 ld-linux.so.3
    echo "$(date): Script run. Symlink status: $? (0 for success)" >> $D/etc/fixruntimehack/fixruntimehack.txt
else
    exit 0;
fi

}

do_install() {

    # this is required so the docker package will run
    install -d ${D}/etc/fixruntimehack
    install -m 0744 ${WORKDIR}/fixruntimehack.txt ${D}/etc/fixruntimehack/

    # ln -s ${D}/lib/ld-linux-armhf.so.3 ${D}/lib/ld-linux.so.3

}

FILES_${PN}="/etc/fixruntimehack/fixruntimehack.txt"
