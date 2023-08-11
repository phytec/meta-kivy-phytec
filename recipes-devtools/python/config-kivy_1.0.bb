# Copyright (C) 2023 Marine Vovard <m.vovard@phytec.de>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Config for kivy"
DEPENDS = "python3-kivy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

FILESEXTRAPATHS:prepend := '${THISDIR}/${BPN}/:'

SRC_URI = "file://kivy-conf.sh"

do_install(){
    install -Dm 0644 ${WORKDIR}/kivy-conf.sh ${D}${sysconfdir}/profile.d/kivy-conf.sh
}
