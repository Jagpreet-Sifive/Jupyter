// Verilated -*- C++ -*-
// DESCRIPTION: Verilator output: Tracing implementation internals
#include "verilated_vcd_c.h"
#include "VMyModule__Syms.h"


//======================

void VMyModule::trace(VerilatedVcdC* tfp, int, int) {
    tfp->spTrace()->addCallback(&VMyModule::traceInit, &VMyModule::traceFull, &VMyModule::traceChg, this);
}
void VMyModule::traceInit(VerilatedVcd* vcdp, void* userthis, uint32_t code) {
    // Callback from vcd->open()
    VMyModule* t=(VMyModule*)userthis;
    VMyModule__Syms* __restrict vlSymsp = t->__VlSymsp;  // Setup global symbol table
    if (!Verilated::calcUnusedSigs()) {
	VL_FATAL_MT(__FILE__,__LINE__,__FILE__,"Turning on wave traces requires Verilated::traceEverOn(true) call before time 0.");
    }
    vcdp->scopeEscape(' ');
    t->traceInitThis(vlSymsp, vcdp, code);
    vcdp->scopeEscape('.');
}
void VMyModule::traceFull(VerilatedVcd* vcdp, void* userthis, uint32_t code) {
    // Callback from vcd->dump()
    VMyModule* t=(VMyModule*)userthis;
    VMyModule__Syms* __restrict vlSymsp = t->__VlSymsp;  // Setup global symbol table
    t->traceFullThis(vlSymsp, vcdp, code);
}

//======================


void VMyModule::traceInitThis(VMyModule__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    vcdp->module(vlSymsp->name());  // Setup signal names
    // Body
    {
	vlTOPp->traceInitThis__1(vlSymsp, vcdp, code);
    }
}

void VMyModule::traceFullThis(VMyModule__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vlTOPp->traceFullThis__1(vlSymsp, vcdp, code);
    }
    // Final
    vlTOPp->__Vm_traceActivity = 0U;
}

void VMyModule::traceInitThis__1(VMyModule__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vcdp->declBit(c+1,"clock",-1);
	vcdp->declBit(c+2,"reset",-1);
	vcdp->declBus(c+3,"io_in",-1,3,0);
	vcdp->declBus(c+4,"io_out",-1,3,0);
	vcdp->declBit(c+1,"MyModule clock",-1);
	vcdp->declBit(c+2,"MyModule reset",-1);
	vcdp->declBus(c+3,"MyModule io_in",-1,3,0);
	vcdp->declBus(c+4,"MyModule io_out",-1,3,0);
    }
}

void VMyModule::traceFullThis__1(VMyModule__Syms* __restrict vlSymsp, VerilatedVcd* vcdp, uint32_t code) {
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    int c=code;
    if (0 && vcdp && c) {}  // Prevent unused
    // Body
    {
	vcdp->fullBit(c+1,(vlTOPp->clock));
	vcdp->fullBit(c+2,(vlTOPp->reset));
	vcdp->fullBus(c+3,(vlTOPp->io_in),4);
	vcdp->fullBus(c+4,(vlTOPp->io_out),4);
    }
}
