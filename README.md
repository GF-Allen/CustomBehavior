# CustomBehavior
自定义CoordinatorLayout的Behavior，实现QQ联系人tab和header动画

### 效果

![](https://github.com/XiqingLiu/CustomBehavior/blob/master/20171026151509.gif?raw=true)

### 大概思路
1. 布局
	主要分三部分，header TabLayout ViewPager，由于CoordinatorLayout继承自ViewGroup，类似FrameLayout,所以需要将子View定位，定位思路重写onLayoutChild，细节查看HeaderTabViewBehavior和HeaderViewPagerBehavior
	* Tab依赖于Header
	* ViewPager依赖于Tab
2. 滑动
	在onNestedPreScroll内处理header的垂直平移