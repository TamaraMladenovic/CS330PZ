package com.example.cs330pz.presentation.nav_bar

import android.graphics.pdf.PdfDocument.Page

data class NavBarState(
    val isMainPage: Boolean = true,
    val localDatabase: Boolean = false,
    val dialog: Boolean = false
)
