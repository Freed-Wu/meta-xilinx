SUMMARY = "OpenMAX Integration layer for VDU"
DESCRIPTION = "OMX IL Libraries,test application and headers for VDU"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=ef69c2bb405668101824f0b644631e2e"

XILINX_VDU_VERSION = "1.0.0"
PV =. "${XILINX_VDU_VERSION}-xilinx-v"
PV .= "+git${SRCPV}"

BRANCH ?= "master"
REPO   ?= "git://github.com/Xilinx/vdu-omx-il.git;protocol=https"
SRCREV ?= "18716131c2d66ed5a0f6f381f155e80a21ca18f4"

BRANCHARG = "${@['nobranch=1', 'branch=${BRANCH}'][d.getVar('BRANCH', True) != '']}"
SRC_URI = "${REPO};${BRANCHARG} \
	  "
S  = "${WORKDIR}/git"

inherit autotools features_check

REQUIRED_MACHINE_FEATURES = "vdu"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:versal-ai-core = "versal-ai-core"
COMPATIBLE_MACHINE:versal-ai-edge = "versal-ai-edge"

PACKAGE_ARCH = "${SOC_FAMILY_ARCH}"

DEPENDS = "libvdu-ctrlsw"
RDEPENDS:${PN} = "kernel-module-vdu libvdu-ctrlsw"

EXTERNAL_INCLUDE="${STAGING_INCDIR}/vdu-ctrl-sw/include"

do_compile[dirs] = "${S}"
do_install[dirs] = "${S}"

EXTRA_OEMAKE = " \
    CC='${CC}' CXX='${CXX} ${CXXFLAGS}' \
    EXTERNAL_INCLUDE='${EXTERNAL_INCLUDE}' \
    INSTALL_PATH=${D}${bindir} \
    INCLUDE_INST_PATH=${D}${includedir} \
    "

do_install:append() {
    install -d ${D}${libdir}

    oe_libinstall -C ${S}/bin/ -so libOMX.allegro.core ${D}/${libdir}/
    oe_libinstall -C ${S}/bin/ -so libOMX.allegro.video_decoder ${D}/${libdir}/
}

# These libraries shouldn't get installed in world builds unless something
# explicitly depends upon them.

EXCLUDE_FROM_WORLD = "1"