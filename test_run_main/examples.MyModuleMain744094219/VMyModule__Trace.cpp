// Verilated -*- C++ -*-
// DESCRIPTION: Verilator output: Tracing implementation internals
#include "verilated_vcd_c.h"
#include "VMyModule__Syms.h"


//======================

void VMyModule::traceChg(VerilatedVcd* vcdp, void* userthis, uint32_t code) {
    // Callback from vcd->dump()
    VMyModule* t=(VMyModule*)userthis;
    VMyModule__Syms* __restrict vlSymsp = t->__VlSymsp;  // Setup global symbol table
    if (vlSymsp->getClearActivity()) {
	t->traceChgThis(vlSymsp, vcdp, code);
    }
}

//======================


void VMyModule::traceChgThis(VMyModule__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vlTOPp->traceChgThis__2(vlSymsp, vcdp, code);
    }
    // Final
    vlTOPp->__Vm_traceActivity = 0U;
}

void VMyModule::traceChgThis__2(VMyModule__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vcdp->chgBit(c+1,(vlTOPp->clock));
	vcdp->chgBit(c+2,(vlTOPp->reset));
	vcdp->chgBus(c+3,(vlTOPp->io_in),4);
	vcdp->chgBus(c+4,(vlTOPp->io_out),4);
    }
}
