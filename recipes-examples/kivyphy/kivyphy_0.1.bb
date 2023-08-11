SUMMARY = "PHYTEC's demo for kivy inspired by the CatalogKivy folder in the kivy examples"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/phytec/kivy-demo;protocol=https;branch=main"
SRC_URI += "file://${BPN}.service"
SRCREV = "d021a20536dbdf200fef9d7c6cd6974e64627540"

# Import images for demo from phytec server
SRC_URI += "https://download.phytec.de/Software/Linux/Applications/Media/phytec_logo_medium.png;subdir=git/kivydemo/images;downloadfilename=PHYTEC.png;sha256sum=a496649e6df34649af8205b0cae64dd617e921a9d9c212e808682474b473df23 \
    https://download.phytec.de/Software/Linux/Applications/Media/IMG_7942.JPG;subdir=git/kivydemo/images;downloadfilename=image_scatter.jpg;sha256sum=8f5511608bbecd3d96c1ed4be9537ee4910fba138dfb5e5a464f1b3e4bbb41bc \
    https://download.phytec.de/Software/Linux/Applications/Media/PHYTEC_Produkte.jpg;subdir=git/kivydemo/images;downloadfilename=background.jpg;sha256sum=c4117bb86fb415cd3cd1d5c3b5b47609e2a1744f2c96483786a87eaa5b80a35a \
    https://download.phytec.de/Software/Linux/Applications/Media/COPYING;subdir=git/kivydemo/images;sha256sum=0fa1d137b8e7b319e6e70b976d74df38715f8917cd9477777b5c581bedb32ed0"

S = "${WORKDIR}"

inherit systemd setuptools3 

SYSTEMD_SERVICE:${PN} = "${BPN}.service"

S = "${WORKDIR}/git"

do_install:append(){
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_system_unitdir}
}

RDEPENDS:${PN} += " \
    weston \
    weston-init \
"

