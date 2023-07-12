SUMMARY = "PHYTEC's demo for kivy inspired by the CatalogKivy folder in the kivy examples"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://kivy-demo-main.zip"
SRC_URI += "file://${BPN}.service"

S = "${WORKDIR}"

inherit systemd setuptools3 

#PACKAGES =+ "${PN}-service"
SYSTEMD_SERVICE:${PN} = "${BPN}.service"
#SYSTEMD_PACKAGES = "${PN}-service"

do_install:append(){
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_system_unitdir}
}

#FILES:${PN}-service += " \
#    ${systemd_system_unitdir}/${BPN}.service \
#"

RDEPENDS:${PN} += " \
    weston \
    weston-init \
"
