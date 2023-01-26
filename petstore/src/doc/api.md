---
title: 宠物商店 v1.0.0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.17"

---

# 宠物商店

> v1.0.0

Base URLs:

# 用户管理

## POST 用户注册

POST /api/register

> Body 请求参数

```json
"{\r\n    \"name\": \"陈王彬\",\r\n    \"email\": \"1234567@qq.com\",\r\n    \"password\": \"12345678\",\r\n    \"addr\": \"浙江工业大学\",\r\n    \"city\": \"杭州\",\r\n    \"country\": \"中国\",\r\n    \"phone\": \"19834476393\"\r\n    \"version\": 0\r\n}"
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» name|body|string| 是 |none|
|» email|body|string| 是 |none|
|» password|body|string| 是 |none|
|» addr|body|string| 是 |none|
|» city|body|string| 是 |none|
|» country|body|string| 是 |none|
|» phone|body|string| 是 |none|
|» version|body|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": null,
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## POST 用户登录

POST /api/login

data中返回的数字0代表用户，1代表商人，2代表管理员

> Body 请求参数

```json
{
  "phone": "string",
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» phone|body|string| 是 |none|
|» password|body|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": {
    "id": 9,
    "password": null,
    "email": "1234567@qq.com",
    "name": "cwb1",
    "addr": "浙江工业大学",
    "city": "杭州",
    "country": "中国",
    "phone": "12345678904",
    "version": 0
  },
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|object|true|none||none|
|»» id|integer|true|none||none|
|»» password|null|true|none||none|
|»» email|string|true|none||none|
|»» name|string|true|none||none|
|»» addr|string|true|none||none|
|»» city|string|true|none||none|
|»» country|string|true|none||none|
|»» phone|string|true|none||none|
|»» version|integer|true|none||none|
|» msg|string|true|none||none|

## POST 修改密码

POST /api/repass

> Body 请求参数

```json
{
  "phone": "string",
  "password": "string"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|body|body|object| 否 |none|
|» phone|body|string| 是 |none|
|» password|body|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": null,
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## GET 获取头像

GET /api/user/image/getimage

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": "/zhang.jpg",
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|string|true|none||none|
|» msg|string|true|none||none|

## POST 更新头像

POST /api/user/image/updateimage

更新用户的头像

> Body 请求参数

```yaml
file: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» file|body|string(binary)| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": null,
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## POST 更新个人信息

POST /api/user/update

更新个人信息（不包括密码和头像）

> Body 请求参数

```json
{
  "email": "12138@qq.com",
  "name": "哈哈哈",
  "addr": "njq",
  "city": "温州",
  "country": "美国"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» email|body|string| 是 |none|
|» name|body|string| 是 |none|
|» addr|body|string| 是 |none|
|» city|body|string| 是 |none|
|» country|body|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": {
    "id": 8,
    "password": null,
    "email": "12138@qq.com",
    "name": "哈哈哈",
    "addr": "njq",
    "city": "温州",
    "country": "美国",
    "phone": "12345678903",
    "version": 0
  },
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|object|true|none||none|
|»» id|integer|true|none||none|
|»» password|null|true|none||none|
|»» email|string|true|none||none|
|»» name|string|true|none||none|
|»» addr|string|true|none||none|
|»» city|string|true|none||none|
|»» country|string|true|none||none|
|»» phone|string|true|none||none|
|»» version|integer|true|none||none|
|» msg|string|true|none||none|

# 店铺操作

## POST 上传待审核的商品

POST /api/shop/submit

> Body 请求参数

```yaml
image: file://C:\Users\dell\Pictures\zhang.jpg
category: 猫
name: 小猫
desc: 可爱的小猫猫
price: "60.6"
number: "5"

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» image|body|string(binary)| 否 |none|
|» category|body|string| 否 |none|
|» name|body|string| 否 |none|
|» desc|body|string| 否 |none|
|» price|body|number| 否 |none|
|» number|body|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": null,
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## POST 删除商品

POST /api/shop/deleteproduct

店铺删除商品，且该操作不可逆

> Body 请求参数

```json
{
  "productid": 27
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» productid|body|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": null,
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## POST 更新商品的信息

POST /api/shop/update

更新指定商品的信息

> Body 请求参数

```json
{
  "category": "猫",
  "name": "猫20",
  "description": "很可爱的猫",
  "id": 20
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» category|body|string| 是 |none|
|» name|body|string| 是 |none|
|» description|body|string| 是 |none|
|» id|body|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": null,
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## POST 为商品添加图片

POST /api/user/image/product/addimage

为商品添加图片，允许一个商品多张照片

> Body 请求参数

```yaml
file: string
productid: "12"

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» file|body|string(binary)| 否 |none|
|» productid|body|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 403,
  "data": null,
  "msg": "图片已经存在"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## POST 删除商品的照片

POST /api/user/image/product/deleteimage

> Body 请求参数

```yaml
imageid: 0
file: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» imageid|body|integer| 否 |none|
|» file|body|string| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": null,
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## GET 商家获取所有未完成的订单

GET /api/shop/order/get

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": [
    {
      "country": "中国",
      "city": "宁波",
      "add": "cwb",
      "num": 2,
      "productname": "狗5",
      "customname": "cwb",
      "productid": 12,
      "orderid": 5
    },
    {
      "country": "中国",
      "city": "宁波",
      "add": "cwb",
      "num": 3,
      "productname": "狗5",
      "customname": "cwb",
      "productid": 12,
      "orderid": 6
    }
  ],
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[object]|true|none||none|
|»» country|string|true|none||none|
|»» city|string|true|none||none|
|»» add|string|true|none||none|
|»» num|integer|true|none||none|
|»» productname|string|true|none||none|
|»» customname|string|true|none||none|
|»» productid|integer|true|none||none|
|»» orderid|integer|true|none||none|
|» msg|string|true|none||none|

## POST 更新商品的数量

POST /api/shop/num/update

> Body 请求参数

```yaml
number: "5"
productid: "20"

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» number|body|integer| 否 |none|
|» productid|body|integer| 否 |none|

> 返回示例

> 200 Response

```json
{
  "code": 0,
  "data": null,
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

# 管理员操作

## POST 审批商品

POST /api/admin/approve

审批商品是否合格

> Body 请求参数

```json
{
  "status": 2,
  "productid": 5
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» status|body|integer| 是 |1代表审核通过，2代表不通过|
|» productid|body|integer| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": null,
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## GET 需要审批的商品

GET /api/admin/unapprove

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|page|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": [
    {
      "id": 19,
      "category": "狗",
      "name": "狗12",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 0,
      "status": 0,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 20,
      "category": "猫",
      "name": "猫20",
      "image": "/zhang.jpg",
      "description": "很可爱的猫",
      "price": 90,
      "version": 0,
      "status": 0,
      "number": 9,
      "shopid": 5
    }
  ],
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[object]|true|none||none|
|»» id|integer|true|none||none|
|»» category|string|true|none||none|
|»» name|string|true|none||none|
|»» image|string|true|none||none|
|»» description|string|true|none||none|
|»» price|integer|true|none||none|
|»» version|integer|true|none||none|
|»» status|integer|true|none||none|
|»» number|integer|true|none||none|
|»» shopid|integer|true|none||none|
|» msg|string|true|none||none|

## GET 下架商品

GET /api/admin/delete

按照商品的id下架指定的商品，将对应的status设置为2，店铺也可以通过这个接口来下架商品，注意用户的权限认证认证。

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|productid|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": null,
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

# 顾客操作/购物车操作

## POST 向购物车里添加商品

POST /api/custom/cart/add

向购物车中添加商品

> Body 请求参数

```yaml
productid: 0

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» productid|body|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": {
    "userid": 8,
    "productid": 18,
    "number": 2,
    "unitcost": 180
  },
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|object|true|none||none|
|»» userid|integer|true|none||none|
|»» productid|integer|true|none||none|
|»» number|integer|true|none||none|
|»» unitcost|integer|true|none||none|
|» msg|string|true|none||none|

## POST 修改购物车中的数量

POST /api/custom/cart/update

修改购物车中的商品的数量

> Body 请求参数

```yaml
productid: 0
number: 0

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» productid|body|integer| 否 |none|
|» number|body|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": {
    "userid": 8,
    "productid": 19,
    "number": 3,
    "unitcost": 270
  },
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|object|true|none||none|
|»» userid|integer|true|none||none|
|»» productid|integer|true|none||none|
|»» number|integer|true|none||none|
|»» unitcost|integer|true|none||none|
|» msg|string|true|none||none|

## POST 删除购物车中的商品

POST /api/custom/cart/delete

删除购物车中的商品

> Body 请求参数

```yaml
productid: 0

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» productid|body|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": null,
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## GET 查看购物车里的商品

GET /api/custom/cart/get

获取用户购物车中的所有商品

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": [
    {
      "userid": 8,
      "productid": 20,
      "number": 5,
      "unitcost": 450
    },
    {
      "userid": 8,
      "productid": 19,
      "number": 3,
      "unitcost": 270
    },
    {
      "userid": 8,
      "productid": 18,
      "number": 2,
      "unitcost": 180
    }
  ],
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[object]|true|none||none|
|»» userid|integer|true|none||none|
|»» productid|integer|true|none||none|
|»» number|integer|true|none||none|
|»» unitcost|integer|true|none||none|
|» msg|string|true|none||none|

# 顾客操作/订单操作

## POST 购物车商品下单

POST /api/custom/cart/purchase

商品下单，清空购物车里的相应的数据，生成相应的订单

> Body 请求参数

```json
{
  "product": [
    {
      "productid": 16,
      "number": 2
    },
    {
      "productid": 17,
      "number": 3
    }
  ],
  "add": "cwb大街",
  "country": "中国",
  "city": "宁波",
  "phone": "18120065333",
  "name": "cwb"
}
```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» product|body|[object]| 是 |none|
|»» productid|body|integer| 是 |none|
|»» number|body|integer| 是 |none|
|» add|body|string| 是 |none|
|» country|body|string| 是 |none|
|» city|body|string| 是 |none|
|» phone|body|string| 是 |none|
|» name|body|string| 是 |none|

> 返回示例

> 成功

```json
{
  "code": 403,
  "data": null,
  "msg": "没有货了"
}
```

> 403 Response

```json
{
  "code": 0,
  "data": null,
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|商品卖光了|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|object|true|none||none|
|»» id|integer|true|none||none|
|»» userid|integer|true|none||none|
|»» modifydate|string|true|none||none|
|»» status|integer|true|none||none|
|»» amount|integer|true|none||none|
|»» addr|string|true|none||none|
|»» city|string|true|none||none|
|»» country|string|true|none||none|
|»» phone|string|true|none||none|
|»» name|string|true|none||none|
|» msg|string|true|none||none|

状态码 **403**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## POST 商品单个下单

POST /api/custom/purchase

单个商品下单

> Body 请求参数

```yaml
country: string
city: string
addr: string
phone: string
productid: 0
name: string

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» country|body|string| 否 |none|
|» city|body|string| 否 |none|
|» addr|body|string| 否 |none|
|» phone|body|string| 否 |none|
|» productid|body|integer| 否 |none|
|» name|body|string| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": {
    "id": 6,
    "userid": 8,
    "modifydate": "2023-01-25T12:28:59.253+00:00",
    "status": 0,
    "amount": 90,
    "addr": "cwb",
    "city": "宁波",
    "country": "中国",
    "phone": "110"
  },
  "msg": "ok"
}
```

```json
{
  "code": 403,
  "data": null,
  "msg": "没有货了"
}
```

> 403 Response

```json
{
  "code": 0,
  "data": null,
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|
|403|[Forbidden](https://tools.ietf.org/html/rfc7231#section-6.5.3)|商品卖光|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|object|true|none||none|
|»» id|integer|true|none||none|
|»» userid|integer|true|none||none|
|»» modifydate|string|true|none||none|
|»» status|integer|true|none||none|
|»» amount|integer|true|none||none|
|»» addr|string|true|none||none|
|»» city|string|true|none||none|
|»» country|string|true|none||none|
|»» phone|string|true|none||none|
|» msg|string|true|none||none|

状态码 **403**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## POST 更新订单状态

POST /api/custom/order/update

> Body 请求参数

```yaml
orderid: "5"

```

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|body|body|object| 否 |none|
|» orderid|body|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": null,
  "msg": "ok"
}
```

> 404 Response

```json
{
  "code": 0,
  "data": null,
  "msg": "string"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|
|404|[Not Found](https://tools.ietf.org/html/rfc7231#section-6.5.4)|记录不存在|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

状态码 **404**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|null|true|none||none|
|» msg|string|true|none||none|

## GET 获取所有的未完成订单

GET /api/custom/uget

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|page|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": [
    {
      "id": 5,
      "userid": 8,
      "modifydate": "2023-01-25T12:28:33.000+00:00",
      "status": 0,
      "amount": 90,
      "addr": "cwb",
      "city": "宁波",
      "country": "中国",
      "phone": "110",
      "name": "cwb"
    },
    {
      "id": 6,
      "userid": 8,
      "modifydate": "2023-01-25T12:28:59.000+00:00",
      "status": 0,
      "amount": 90,
      "addr": "cwb",
      "city": "宁波",
      "country": "中国",
      "phone": "110",
      "name": "cwb"
    }
  ],
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[object]|true|none||none|
|»» id|integer|true|none||none|
|»» userid|integer|true|none||none|
|»» modifydate|string|true|none||none|
|»» status|integer|true|none||none|
|»» amount|integer|true|none||none|
|»» addr|string|true|none||none|
|»» city|string|true|none||none|
|»» country|string|true|none||none|
|»» phone|string|true|none||none|
|»» name|string|true|none||none|
|» msg|string|true|none||none|

## GET 获取所有的订单

GET /api/custom/get

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|page|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": [
    {
      "id": 5,
      "userid": 8,
      "modifydate": "2023-01-25T12:28:33.000+00:00",
      "status": 0,
      "amount": 90,
      "addr": "cwb",
      "city": "宁波",
      "country": "中国",
      "phone": "110",
      "name": "cwb"
    },
    {
      "id": 6,
      "userid": 8,
      "modifydate": "2023-01-25T12:28:59.000+00:00",
      "status": 0,
      "amount": 90,
      "addr": "cwb",
      "city": "宁波",
      "country": "中国",
      "phone": "110",
      "name": "cwb"
    },
    {
      "id": 7,
      "userid": 8,
      "modifydate": "2023-01-25T13:20:14.000+00:00",
      "status": 1,
      "amount": 450,
      "addr": "cwb大街",
      "city": "宁波",
      "country": "中国",
      "phone": "18120065333",
      "name": "cwb"
    },
    {
      "id": 8,
      "userid": 8,
      "modifydate": "2023-01-25T13:24:01.000+00:00",
      "status": 1,
      "amount": 90,
      "addr": "cwb",
      "city": "宁波",
      "country": "中国",
      "phone": "110",
      "name": "cwb"
    }
  ],
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[object]|true|none||none|
|»» id|integer|true|none||none|
|»» userid|integer|true|none||none|
|»» modifydate|string|true|none||none|
|»» status|integer|true|none||none|
|»» amount|integer|true|none||none|
|»» addr|string|true|none||none|
|»» city|string|true|none||none|
|»» country|string|true|none||none|
|»» phone|string|true|none||none|
|»» name|string|true|none||none|
|» msg|string|true|none||none|

## GET 获取具体的订单信息

GET /api/custom/order/get

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|
|orderid|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": [
    {
      "orderid": 9,
      "productid": 16,
      "number": 2,
      "unitcost": 180,
      "shopid": 6
    },
    {
      "orderid": 9,
      "productid": 17,
      "number": 3,
      "unitcost": 270,
      "shopid": 6
    }
  ],
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[object]|true|none||none|
|»» orderid|integer|true|none||none|
|»» productid|integer|true|none||none|
|»» number|integer|true|none||none|
|»» unitcost|integer|true|none||none|
|»» shopid|integer|true|none||none|
|» msg|string|true|none||none|

# 通用操作

## GET 获取指定店铺的商品

GET /api/user/getstore

获取一个商铺下的所有商品，要求分页，并且按照销量做一个降序排序，这个接口由客户、管理员、商家共享。

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|stroeid|query|integer| 否 |none|
|page|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": [
    {
      "id": 14,
      "category": "狗",
      "name": "狗7",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 6,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 11,
      "category": "狗",
      "name": "狗4",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 4,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 15,
      "category": "狗",
      "name": "狗8",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 3,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 9,
      "category": "狗",
      "name": "狗2",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 2,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 10,
      "category": "狗",
      "name": "狗3",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 1,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 13,
      "category": "狗",
      "name": "狗6",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 1,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 16,
      "category": "狗",
      "name": "狗9",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 0,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 17,
      "category": "狗",
      "name": "狗10",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 0,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 18,
      "category": "狗",
      "name": "狗11",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 0,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 19,
      "category": "狗",
      "name": "狗12",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 0,
      "status": 1,
      "number": 6,
      "shopid": 6
    }
  ],
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[object]|true|none||none|
|»» id|integer|true|none||none|
|»» category|string|true|none||none|
|»» name|string|true|none||none|
|»» image|string|true|none||none|
|»» description|string|true|none||none|
|»» price|integer|true|none||none|
|»» version|integer|true|none||none|
|»» status|integer|true|none||none|
|»» number|integer|true|none||none|
|»» shopid|integer|true|none||none|
|» msg|string|true|none||none|

## GET 获取所有商品

GET /api/user/getall

获取所有商品，要求分页，并且按照销量做一个降序排序，这个接口由客户、管理员、商家共享。

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|page|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": [
    {
      "id": 14,
      "category": "狗",
      "name": "狗7",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 6,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 11,
      "category": "狗",
      "name": "狗4",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 4,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 8,
      "category": "狗",
      "name": "狗1",
      "image": "/zhang.jpg",
      "description": "可爱的小狗",
      "price": 30.99,
      "version": 3,
      "status": 1,
      "number": 3,
      "shopid": 5
    },
    {
      "id": 15,
      "category": "狗",
      "name": "狗8",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 3,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 9,
      "category": "狗",
      "name": "狗2",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 2,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 12,
      "category": "狗",
      "name": "狗5",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 2,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 7,
      "category": "猫",
      "name": "大猫",
      "image": "/liu.jpg",
      "description": "很可爱的猫猫",
      "price": 80.9,
      "version": 1,
      "status": 1,
      "number": 7,
      "shopid": 5
    },
    {
      "id": 10,
      "category": "狗",
      "name": "狗3",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 1,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 13,
      "category": "狗",
      "name": "狗6",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 1,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 6,
      "category": "猫",
      "name": "小猫",
      "image": "/zhang.jpg",
      "description": "可爱的小猫猫",
      "price": 60.6,
      "version": 0,
      "status": 1,
      "number": 5,
      "shopid": 5
    }
  ],
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[object]|true|none||none|
|»» id|integer|true|none||none|
|»» category|string|true|none||none|
|»» name|string|true|none||none|
|»» image|string|true|none||none|
|»» description|string|true|none||none|
|»» price|integer|true|none||none|
|»» version|integer|true|none||none|
|»» status|integer|true|none||none|
|»» number|integer|true|none||none|
|»» shopid|integer|true|none||none|
|» msg|string|true|none||none|

## GET 获取分类选项

GET /api/user/getcategory

获取分类选项，查看有多少动物的分类, 这个接口由客户、管理员、商家共享。

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|SESSION|cookie|string| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": [
    "猫",
    "狗"
  ],
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[string]|true|none||none|
|» msg|string|true|none||none|

## GET 获取分类下的商品

GET /api/user/category/getproduct

获取一个分类下的商品，需要分页，按照销量降序排序，这个接口由客户、管理员、商家共享。

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|category|query|string| 否 |none|
|page|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": [
    {
      "id": 14,
      "category": "狗",
      "name": "狗7",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 6,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 11,
      "category": "狗",
      "name": "狗4",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 4,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 8,
      "category": "狗",
      "name": "狗1",
      "image": "/zhang.jpg",
      "description": "可爱的小狗",
      "price": 30.99,
      "version": 3,
      "status": 1,
      "number": 3,
      "shopid": 5
    },
    {
      "id": 15,
      "category": "狗",
      "name": "狗8",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 3,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 9,
      "category": "狗",
      "name": "狗2",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 2,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 12,
      "category": "狗",
      "name": "狗5",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 2,
      "status": 1,
      "number": 6,
      "shopid": 5
    },
    {
      "id": 10,
      "category": "狗",
      "name": "狗3",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 1,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 13,
      "category": "狗",
      "name": "狗6",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 1,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 16,
      "category": "狗",
      "name": "狗9",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 0,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 17,
      "category": "狗",
      "name": "狗10",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 0,
      "status": 1,
      "number": 6,
      "shopid": 6
    }
  ],
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[object]|true|none||none|
|»» id|integer|true|none||none|
|»» category|string|true|none||none|
|»» name|string|true|none||none|
|»» image|string|true|none||none|
|»» description|string|true|none||none|
|»» price|integer|true|none||none|
|»» version|integer|true|none||none|
|»» status|integer|true|none||none|
|»» number|integer|true|none||none|
|»» shopid|integer|true|none||none|
|» msg|string|true|none||none|

## GET 获得对应商店的动物的分类的商品

GET /api/user/catrgory/shop/getproducts

获取一个商铺下的一个分类的所有商品，要求分页，并且按照销量做一个降序排序，这个接口由客户、管理员、商家共享。

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|shopid|query|integer| 否 |none|
|category|query|string| 否 |none|
|page|query|string| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": [
    {
      "id": 14,
      "category": "狗",
      "name": "狗7",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 6,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 11,
      "category": "狗",
      "name": "狗4",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 4,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 15,
      "category": "狗",
      "name": "狗8",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 3,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 9,
      "category": "狗",
      "name": "狗2",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 2,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 10,
      "category": "狗",
      "name": "狗3",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 1,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 13,
      "category": "狗",
      "name": "狗6",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 1,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 16,
      "category": "狗",
      "name": "狗9",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 0,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 17,
      "category": "狗",
      "name": "狗10",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 0,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 18,
      "category": "狗",
      "name": "狗11",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 0,
      "status": 1,
      "number": 6,
      "shopid": 6
    },
    {
      "id": 19,
      "category": "狗",
      "name": "狗12",
      "image": "/zhang.jpg",
      "description": "很可爱的大狗",
      "price": 90,
      "version": 0,
      "status": 1,
      "number": 6,
      "shopid": 6
    }
  ],
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[object]|true|none||none|
|»» id|integer|true|none||none|
|»» category|string|true|none||none|
|»» name|string|true|none||none|
|»» image|string|true|none||none|
|»» description|string|true|none||none|
|»» price|integer|true|none||none|
|»» version|integer|true|none||none|
|»» status|integer|true|none||none|
|»» number|integer|true|none||none|
|»» shopid|integer|true|none||none|
|» msg|string|true|none||none|

## GET 获取商品的照片

GET /api/user/image/product/getimage

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|productid|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": [
    {
      "imageid": 6,
      "imageurl": "/product/5/zhang.jpg"
    },
    {
      "imageid": 7,
      "imageurl": "/product/5/20220920182036.jpg"
    }
  ],
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|[object]|true|none||none|
|»» imageid|integer|true|none||none|
|»» imageurl|string|true|none||none|
|» msg|string|true|none||none|

## GET 获取单个商品的信息

GET /api/user/getone

### 请求参数

|名称|位置|类型|必选|说明|
|---|---|---|---|---|
|productid|query|integer| 否 |none|

> 返回示例

> 成功

```json
{
  "code": 200,
  "data": {
    "id": 27,
    "category": "猫",
    "name": "小猫",
    "image": "/product/27/zhang.jpg",
    "description": "可爱的小猫猫",
    "price": 60.6,
    "version": 0,
    "status": 0,
    "number": 5,
    "shopid": 5
  },
  "msg": "ok"
}
```

### 返回结果

|状态码|状态码含义|说明|数据模型|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|成功|Inline|

### 返回数据结构

状态码 **200**

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» data|object|true|none||none|
|»» id|integer|true|none||none|
|»» category|string|true|none||none|
|»» name|string|true|none||none|
|»» image|string|true|none||none|
|»» description|string|true|none||none|
|»» price|number|true|none||none|
|»» version|integer|true|none||none|
|»» status|integer|true|none||none|
|»» number|integer|true|none||none|
|»» shopid|integer|true|none||none|
|» msg|string|true|none||none|

# 数据模型

<h2 id="tocS_返回数据结构">返回数据结构</h2>

<a id="schema返回数据结构"></a>
<a id="schema_返回数据结构"></a>
<a id="tocS返回数据结构"></a>
<a id="tocs返回数据结构"></a>

```json
{
  "data": "string",
  "code": 0,
  "msg": "string"
}

```

### 属性

|名称|类型|必选|约束|中文名|说明|
|---|---|---|---|---|---|
|data|string|true|none||none|
|code|integer|true|none||none|
|msg|string|true|none||none|

