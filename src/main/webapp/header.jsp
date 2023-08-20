<!-- Header -->
<header class="bg-white p-4 flex justify-between items-center">
    <button id="sidebarToggle" class="text-gray-500 focus:outline-none">
        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor"
             class="w-6 h-6">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                  d="M4 6h16M4 12h8m-8 6h16"></path>
        </svg>
    </button>
    <div class="user-info flex items-center">
        <div class="user-icon bg-cyan-500 rounded-full flex items-center justify-center">
            <svg class="w-6 h-6" viewBox="0 0 24 24">
                <path fill="white"
                      d="M9 2a7 7 0 0 1 6.062 3.499c-.039.16-.183.525-.438.72 2.13.526 3.89 1.576 5.174 3.063a8.001 8.001 0 0 1-6.89 12.3 8 8 0 0 1-12.29 7.1 8.003 8.003 0 0 1 10.036-11.927c.366-.65.744-1.456.766-1.6A6.963 6.963 0 0 1 9 2zm-4.28 17.464a5.989 5.989 0 0 0 4.274 2.828 5.989  5.989 0 0 0 4.274-2.828c.348-.619.706-1.386.715-1.529a4.996 4.996 0 0 0-9.898-.224c.011.143.369.91.717 1.53zm7.28-6.464c2.761 0 5-2.239 5-5s-2.239-5-5-5-5 2.239-5 5 2.239 5 5 5zm0-9a3.001 3.001 0 0 1 0 6 3.001 3.001 0 0 1 0-6zm0 4a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"></path>
            </svg>
        </div>
        <div class="ml-2">

            <span class="block text-gray-600 text-sm"> ${sessionScope.currentUser.username}</span>
            <button id="logout" onclick="logout()" class="block text-cyan-600 text-xs mt-1">Logout</button>
        </div>
    </div>
</header>