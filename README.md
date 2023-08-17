# line-order 
利用Spring Boot來實作模擬一家咖啡簡餐店的行動預點功能的後端及jsp來完成前端的畫面配置！ 

# 頁面功能說明：
`OrderController` - 呈現菜單頁面資訊、呈現商品詳細資訊及加入購物車功能api

`ShopCarController` - 呈現購物車頁面資訊、調整數量功能api

`OrderCheckController` - 接受前端選取取餐時間及統整購物車頁面資料api

`OrderCheckPay` - 統整最終訂單資訊api

`ConfirmOrderController` - 實作Line Pay Api功能(Request API、Confirm API)

`SucessPayController` - 呈現訂單完成詳細資訊api

`OrderHistoryController` - 呈現歷史訂單資訊api

`OrderHistoryDetailController` - 呈現歷史指定訂單的詳細資訊

# API URL 列表：
- 商品頁面
```
/order
```
- 商品詳細資訊
```
/order/orderData
```
- 將商品加入購物車
```
/order/checkToShopCar
```
- 購物車畫面
```
/shopCar
```
- 購物車移除商品
```
/shopCar/remove
```
- 購物車新增、減少商品數量
```
/shopCar/edit
```
- 確認明細及選擇取餐時間
```
/orderCheck
```
- 確認付款
```
/orderCheckPay
```
- LINE PAY RequestAPI
```
/confirmOrder/checkLinePay
```
- LINE PAY ConfirmAPI
```
/confirmOrder/checkPay
```
- 付款成功頁面
```
/sucessPay
```
- 過去訂單紀錄
```
/orderHistory
```
- 過去訂單記錄(詳細資料)
```
/angular/orderHistory
```

# 資料庫使用
- Oracle 19c
- Mybatis
# 登入方式
- LINE LIFF 串聯 Line登入
# 前端頁面
### 商品頁面
- order.jsp
### 商品詳細資訊頁面
- productDetail.jsp
### 購物車頁面
- shopCar.jsp
### 確認明細及選擇取餐時間頁面
- checkOutOrder.jsp
### 確認訂單頁面
- orderCheckPay.jsp
### 付款完成頁面
- sucessPay.jsp
### 查看歷史訂單頁面
- orderHistory.jsp
### 歷史訂單詳細資料頁面
- orderHistoryDetail.jsp
