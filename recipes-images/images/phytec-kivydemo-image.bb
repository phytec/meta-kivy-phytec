# Copyright (C) 2023 Marine Vovard <m.vovard@phytec.de>
# Released under the MIT license (see COPYING.MIT for the terms)
require recipes-images/images/phytec-headless-image.bb

SUMMARY = "This image is designed to show development of a Kivy demo \
            running as an application on wayland."

LICENSE = "MIT"

IMAGE_FEATURES += "\
    splash \
    ssh-server-openssh \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', '', d)} \
"

IMAGE_INSTALL += "\
    packagegroup-base \
    \
    packagegroup-gstreamer \
    \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston weston-init', '', d)} \
    python3-kivy \
    kivyphy \
    configkivy \
"

IMAGE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland', '', d)}"
