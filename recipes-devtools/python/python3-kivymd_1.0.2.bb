SUMMARY = "Collection of Material Design widgets for Kivy"

DESCRIPTION = "\
KivyMD is a collection of Material Design compliant widgets for use with Kivy,\
 a framework for cross-platform, touch-enabled graphical applications."

HOMEPAGE = "https://github.com/kivymd/KivyMD"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6051bf88b68c801731d4496edd2872a9"

#FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " file://setup.patch "

SRC_URI[sha256sum] = "4274721bd9672d507fbe70dc5173a1ce8c57d9f305f91d2bea58bf588c49fe62"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-kivy \
    python3-pillow \
"
