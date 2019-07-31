// Verilated -*- C++ -*-
// DESCRIPTION: Verilator output: Design implementation internals
// See VMyModule.h for the primary calling header

#include "VMyModule.h"
#include "VMyModule__Syms.h"


//--------------------
// STATIC VARIABLES


//--------------------

VL_CTOR_IMP(VMyModule) {
    VMyModule__Syms* __restrict vlSymsp = __VlSymsp = new VMyModule__Syms(this, name());
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Reset internal values
    
    // Reset structure values
    _ctor_var_reset();
}

void VMyModule::__Vconfigure(VMyModule__Syms* vlSymsp, bool first) {
    if (0 && first) {}  // Prevent unused
    this->__VlSymsp = vlSymsp;
}

VMyModule::~VMyModule() {
    delete __VlSymsp; __VlSymsp=NULL;
}

//--------------------


void VMyModule::eval() {
    VL_DEBUG_IF(VL_DBG_MSGF("+++++TOP Evaluate VMyModule::eval\n"); );
    VMyModule__Syms* __restrict vlSymsp = this->__VlSymsp;  // Setup global symbol table
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
#ifdef VL_DEBUG
    // Debug assertions
    _eval_debug_assertions();
#endif // VL_DEBUG
    // Initialize
    if (VL_UNLIKELY(!vlSymsp->__Vm_didInit)) _eval_initial_loop(vlSymsp);
    // Evaluate till stable
    int __VclockLoop = 0;
    QData __Vchange = 1;
    do {
	VL_DEBUG_IF(VL_DBG_MSGF("+ Clock loop\n"););
	vlSymsp->__Vm_activity = true;
	_eval(vlSymsp);
	if (VL_UNLIKELY(++__VclockLoop > 100)) {
	    // About to fail, so enable debug to see what's not settling.
	    // Note you must run make with OPT=-DVL_DEBUG for debug prints.
	    int __Vsaved_debug = Verilated::debug();
	    Verilated::debug(1);
	    __Vchange = _change_request(vlSymsp);
	    Verilated::debug(__Vsaved_debug);
	    VL_FATAL_MT(__FILE__,__LINE__,__FILE__,"Verilated model didn't converge");
	} else {
	    __Vchange = _change_request(vlSymsp);
	}
    } while (VL_UNLIKELY(__Vchange));
}

void VMyModule::_eval_initial_loop(VMyModule__Syms* __restrict vlSymsp) {
    vlSymsp->__Vm_didInit = true;
    _eval_initial(vlSymsp);
    vlSymsp->__Vm_activity = true;
    // Evaluate till stable
    int __VclockLoop = 0;
    QData __Vchange = 1;
    do {
	_eval_settle(vlSymsp);
	_eval(vlSymsp);
	if (VL_UNLIKELY(++__VclockLoop > 100)) {
	    // About to fail, so enable debug to see what's not settling.
	    // Note you must run make with OPT=-DVL_DEBUG for debug prints.
	    int __Vsaved_debug = Verilated::debug();
	    Verilated::debug(1);
	    __Vchange = _change_request(vlSymsp);
	    Verilated::debug(__Vsaved_debug);
	    VL_FATAL_MT(__FILE__,__LINE__,__FILE__,"Verilated model didn't DC converge");
	} else {
	    __Vchange = _change_request(vlSymsp);
	}
    } while (VL_UNLIKELY(__Vchange));
}

//--------------------
// Internal Methods

VL_INLINE_OPT void VMyModule::_combo__TOP__1(VMyModule__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_DBG_MSGF("+    VMyModule::_combo__TOP__1\n"); );
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Body
    vlTOPp->io_out = vlTOPp->io_in;
}

void VMyModule::_eval(VMyModule__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_DBG_MSGF("+    VMyModule::_eval\n"); );
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Body
    vlTOPp->_combo__TOP__1(vlSymsp);
}

void VMyModule::_eval_initial(VMyModule__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_DBG_MSGF("+    VMyModule::_eval_initial\n"); );
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
}

void VMyModule::final() {
    VL_DEBUG_IF(VL_DBG_MSGF("+    VMyModule::final\n"); );
    // Variables
    VMyModule__Syms* __restrict vlSymsp = this->__VlSymsp;
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
}

void VMyModule::_eval_settle(VMyModule__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_DBG_MSGF("+    VMyModule::_eval_settle\n"); );
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Body
    vlTOPp->_combo__TOP__1(vlSymsp);
}

VL_INLINE_OPT QData VMyModule::_change_request(VMyModule__Syms* __restrict vlSymsp) {
    VL_DEBUG_IF(VL_DBG_MSGF("+    VMyModule::_change_request\n"); );
    VMyModule* __restrict vlTOPp VL_ATTR_UNUSED = vlSymsp->TOPp;
    // Body
    // Change detection
    QData __req = false;  // Logically a bool
    return __req;
}

#ifdef VL_DEBUG
void VMyModule::_eval_debug_assertions() {
    VL_DEBUG_IF(VL_DBG_MSGF("+    VMyModule::_eval_debug_assertions\n"); );
    // Body
    if (VL_UNLIKELY((clock & 0xfeU))) {
	Verilated::overWidthError("clock");}
    if (VL_UNLIKELY((reset & 0xfeU))) {
	Verilated::overWidthError("reset");}
    if (VL_UNLIKELY((io_in & 0xf0U))) {
	Verilated::overWidthError("io_in");}
}
#endif // VL_DEBUG

void VMyModule::_ctor_var_reset() {
    VL_DEBUG_IF(VL_DBG_MSGF("+    VMyModule::_ctor_var_reset\n"); );
    // Body
    clock = VL_RAND_RESET_I(1);
    reset = VL_RAND_RESET_I(1);
    io_in = VL_RAND_RESET_I(4);
    io_out = VL_RAND_RESET_I(4);
    __Vm_traceActivity = VL_RAND_RESET_I(32);
}
