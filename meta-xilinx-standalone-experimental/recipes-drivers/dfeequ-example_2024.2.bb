# Copyright (C) 2024 Advanced Micro Devices, Inc.  All rights reserved.
inherit esw_examples features_check

REQUIRED_MACHINE_FEATURES = "dfeequ"

DEPENDS += " dfeequ"

ESW_COMPONENT_SRC = "/XilinxProcessorIPLib/drivers/dfeequ/examples/"
