<div class="header navbar navbar-inverse ">
    <!-- BEGIN TOP NAVIGATION BAR -->
    <div class="navbar-inner">
        <div class="header-seperation">
            <ul class="nav pull-left notifcation-center visible-xs visible-sm">
                <li class="dropdown">
                    <a href="#main-menu" data-webarch="toggle-left-side">
                        <i class="material-icons">menu</i>
                    </a>
                </li>
            </ul>
            <!-- BEGIN LOGO -->
            <a href="index.html">
                <img src="${pageContext.request.contextPath}/resources/webarch/assets/img/logo.png"
                     class="logo" alt="" data-src="${pageContext.request.contextPath}/resources/webarch/assets/img/logo.png"
                     data-src-retina="${pageContext.request.contextPath}/resources/webarch/assets/img/logo2x.png" width="106" height="21" />
            </a>
            <!-- END LOGO -->

        </div>
        <!-- END RESPONSIVE MENU TOGGLER -->
        <div class="header-quick-nav">
            <!-- BEGIN TOP NAVIGATION MENU -->
            <div class="pull-left">
                <ul class="nav quick-section">
                    <li class="quicklinks">
                        <a href="#" class="" id="layout-condensed-toggle">
                            <i class="material-icons">menu</i>
                        </a>
                    </li>
                </ul>
                <ul class="nav quick-section">

                    <li class="quicklinks">
                        <a href="#" class="" id="my-task-list" data-placement="bottom"
                           data-content="" data-toggle="dropdown"
                           data-original-title="Notifications">
                            <i class="material-icons">notifications_none</i>
                            <span class="badge badge-important bubble-only"></span>
                        </a>
                    </li>
                    <li class="m-r-10 input-prepend inside search-form no-boarder">
                        <span class="add-on"> <i class="material-icons">search</i></span>
                        <input name="" type="text" class="no-boarder " placeholder="Procurar..." style="width:250px;">
                    </li>
                </ul>
            </div>
            <div id="notification-list" style="display:none">
                <div style="width:300px">
                    <div class="notification-messages info">
                        <div class="user-profile">
                            <img src="${pageContext.request.contextPath}/resources/webarch/assets/img/profiles/d.jpg" alt=""
                                 data-src="${pageContext.request.contextPath}/resources/webarch/assets/img/profiles/d.jpg"
                                 data-src-retina="${pageContext.request.contextPath}/resources/webarch/assets/img/profiles/d2x.jpg" width="35" height="35">
                        </div>
                        <div class="message-wrapper">
                            <div class="heading">
                                David Nester - Commented on your wall
                            </div>
                            <div class="description">
                                Meeting postponed to tomorrow
                            </div>
                            <div class="date pull-left">
                                A min ago
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!-- END TOP NAVIGATION MENU -->
            <!-- BEGIN CHAT TOGGLER -->
            <div class="pull-right">
                <div class="chat-toggler sm">
                    <div class="profile-pic">
                        <img src="${pageContext.request.contextPath}/resources/webarch/assets/img/profiles/avatar_small.jpg"
                             alt="" data-src="${pageContext.request.contextPath}/resources/webarch/assets/img/profiles/avatar_small.jpg"
                             data-src-retina="${pageContext.request.contextPath}/resources/webarch/assets/img/profiles/avatar_small2x.jpg" width="35" height="35" />
                        <div class="availability-bubble online"></div>
                    </div>
                </div>
                <ul class="nav quick-section ">
                    <li class="quicklinks">
                        <a data-toggle="dropdown" class="dropdown-toggle  pull-right " href="#" id="user-options">
                            <i class="material-icons">tune</i>
                        </a>
                        <ul class="dropdown-menu  pull-right" role="menu" aria-labelledby="user-options">
                            <li>
                                <a href="user-profile.html"> My Account</a>
                            </li>
                            <li>
                                <a href="calender.html">My Calendar</a>
                            </li>
                            <li>
                                <a href="email.html"> My Inbox&nbsp;&nbsp;
                                    <span class="badge badge-important animated bounceIn">2</span>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                               <a href="logout">Sair<a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- END CHAT TOGGLER -->
        </div>
        <!-- END TOP NAVIGATION MENU -->
    </div>
    <!-- END TOP NAVIGATION BAR -->
</div>
