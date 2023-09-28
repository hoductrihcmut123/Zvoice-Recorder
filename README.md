# zvoice-recorder
## Android, Kotlin



## Requirements

Ứng dụng record voice với các tính năng sau:
 + Quản lý danh sách các file đã record, cho nghe lại
 + Cho record 1 voice mới, home app hay khoá màn hình đều phải record được
 + Record liên tục, tức dù đang record mà app bị crash hay hết pin restart thì file đang record được save thành công ko mất
 + Dùng sqlite lưu trữ data, không dùng thư viện mapping sqlite
 + Màn hình nghe lại có noti để có thể chạy background như các app nghe nhạc 
 + (Optional) Cho phép upload lên drive dùng HTTP REST API
 
 Hạn chế dùng library bên ngoài trừ các lib support, lib google-service


## Record một voice mới

 <img src="https://github.com/hoductrihcmut123/zvoice-recorder/assets/76983358/3a83eff2-2de8-4e6b-902e-06bf95ff2f98" width="150">
 <img src="https://github.com/hoductrihcmut123/zvoice-recorder/assets/76983358/02f727e6-0cb6-4660-8039-9a5695ee0d59" width="150">
 <img src="https://github.com/hoductrihcmut123/zvoice-recorder/assets/76983358/932794b2-028c-4700-b075-56bbc7d631f8" width="150">
 <img src="https://github.com/hoductrihcmut123/zvoice-recorder/assets/76983358/00bab9d6-e8c4-4ce7-8c0d-76273e2b599e" width="150">
 <img src="https://github.com/hoductrihcmut123/zvoice-recorder/assets/76983358/04fa45fd-3726-4ab0-a64c-c8b31a7f986e" width="150">
 <img src="https://github.com/hoductrihcmut123/zvoice-recorder/assets/76983358/a397c6f9-d70e-4fe0-925d-50243644c38a" width="150">
 <img src="https://github.com/hoductrihcmut123/zvoice-recorder/assets/76983358/a574a1e6-22a0-4384-b8e6-a370926765c3" width="150">


## Record liên tục 

 <img src="https://github.com/hoductrihcmut123/zvoice-recorder/assets/76983358/229405fe-3b7f-492d-aaad-075b09cee903" width="200">
 <img src="https://github.com/hoductrihcmut123/zvoice-recorder/assets/76983358/c742f423-c077-4e86-8f61-f6a75b18bced" width="200">
 <img src="https://github.com/hoductrihcmut123/zvoice-recorder/assets/76983358/ec94857f-b860-4d50-9497-50fa38c40bd3" width="200">
 <img src="https://github.com/hoductrihcmut123/zvoice-recorder/assets/76983358/f4568d0f-fa56-4edd-8e1d-cb61862f6c4f" width="200">


## Quản lý danh sách các file

** Đổi tên file:
** Search theo tên:
** Xóa 1 file:
** Xóa nhiều file:

## Nghe lại các file đã record

## Upload lên Drive

** Upload 1 file
** Upload nhiều file
