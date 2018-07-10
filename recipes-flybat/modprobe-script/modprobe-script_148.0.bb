SUMMARY="adds bluetooth blacklist"
DESCRIPTION="Adds a file in /etc/modprobe.d/raspi-blacklist.conf to blacklist bluetooth"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "\
        file://raspi-blacklist.conf \
"

do_install() {

    # this is required so the docker package will run
    install -m 0644 ${WORKDIR}/raspi-blacklist.conf ${D}/etc/modprobe.d/

}

FILES_${PN}="/etc/modprobe.d/raspi-blacklist.conf"

