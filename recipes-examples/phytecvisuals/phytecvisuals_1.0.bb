# Copyright (C) 2023 Marine Vovard <m.vovard@phytec.de>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Install PHYTEC pictures and keyvisuals in the opt folder and use for demo"
HOMEPAGE = "https://download.phytec.de/Software/Linux/Applications/Media/"
LICENSE = "CLOSED" 
LIC_FILES_CHKSUM = "file://COPYING"

S = "${WORKDIR}"

SRC_URI = "https://download.phytec.de/Software/Linux/Applications/Media/phytec_logo_medium.png;subdir=visuals;sha256sum=a496649e6df34649af8205b0cae64dd617e921a9d9c212e808682474b473df23 \
        https://download.phytec.de/Software/Linux/Applications/Media/IMG_7942.JPG;subdir=visuals;sha256sum=8f5511608bbecd3d96c1ed4be9537ee4910fba138dfb5e5a464f1b3e4bbb41bc \
    https://download.phytec.de/Software/Linux/Applications/Media/PHYTEC_Produkte.jpg;subdir=visuals;sha256sum=c4117bb86fb415cd3cd1d5c3b5b47609e2a1744f2c96483786a87eaa5b80a35a \
    https://download.phytec.de/Software/Linux/Applications/Media/COPYING;sha256sum=016135b8d3f6bbe8884ce0808bf4149e263a15884a94b47566a7b011740884bf"

do_install(){
    install -d ${D}${datadir}/phytecvisuals
    for file in ${WORKDIR}/visuals/*;do
        install -m 0644 "$file" ${D}${datadir}/phytecvisuals
    done
}

FILES:${PN} += "${datadir}/phytecvisuals/"
