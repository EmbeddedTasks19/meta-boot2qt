#############################################################################
##
## Copyright (C) 2014 Digia Plc and/or its subsidiary(-ies).
##
## This file is part of the Qt Enterprise Embedded Scripts of the Qt
## framework.
##
## $QT_BEGIN_LICENSE$
## Commercial License Usage Only
## Licensees holding valid commercial Qt license agreements with Digia
## with an appropriate addendum covering the Qt Enterprise Embedded Scripts,
## may use this file in accordance with the terms contained in said license
## agreement.
##
## For further information use the contact form at
## http://www.qt.io/contact-us.
##
##
## $QT_END_LICENSE$
##
#############################################################################

DESCRIPTION = "Proxy daemon for QtSimulator"
LICENSE = "QtEnterprise"
LIC_FILES_CHKSUM = "file://proxy.h;md5=ba04e32af7257890758a149b0c14d11a;beginline=1;endline=17"

inherit qt5-module

SRC_URI = " \
    git://codereview.qt-project.org/tqtc-boot2qt/emulator;branch=${BRANCH};protocol=ssh \
    file://emulatorproxyd.sh \
    "

SRCREV = "1d001910d45349ae2a44fa01516baaa7ff4c9eda"
BRANCH = "master"

S = "${WORKDIR}/git/src/helperlibs/proxy"

DEPENDS = "qtbase qtsimulator"

do_install_append() {
    install -m 0755 -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/emulatorproxyd.sh ${D}${sysconfdir}/init.d/
}

INITSCRIPT_NAME = "emulatorproxyd.sh"
INITSCRIPT_PARAMS = "defaults 97 10"

inherit update-rc.d