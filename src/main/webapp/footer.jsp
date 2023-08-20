
<!-- Footer -->
<footer class="bg-white p-4 text-center">
  Powered by Texas BCA student
</footer>

<script>
  const logo = document.querySelector('.logo-normal');

  document.getElementById('sidebarToggle').addEventListener('click', () => {
    const sidebar = document.querySelector('.sidebar');
    sidebar.classList.toggle('sidebar-collapsed');
    logo.classList.toggle('logo-collapsed');
  });

  function logout() {
    window.location.href = "${pageContext.request.contextPath}/logout?action=logout";
  }
</script>
</body>
</html>
