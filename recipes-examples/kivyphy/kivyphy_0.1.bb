SUMMARY = "PHYTEC's demo for kivy inspired by the CatalogKivy folder in the kivy examples"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/phytec/kivy-demo;protocol=https;branch=main"

SRCREV = "f2b84a0c9afc788ae4110c6f8b2921c17a3b2c73"

FILESEXTRAPATHS:prepend := '${THISDIR}/${BPN}/:'

SRC_URI += "file://${BPN}.service"

S = "${WORKDIR}"

inherit systemd setuptools3 

SYSTEMD_SERVICE:${PN} = "${BPN}.service"

S = "${WORKDIR}/git"

do_install:append(){
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_system_unitdir}
}

RDEPENDS:${PN} += " \
    python3-kivy \
    configkivy \
    weston \
    weston-init \
    phytecvisuals \
"
